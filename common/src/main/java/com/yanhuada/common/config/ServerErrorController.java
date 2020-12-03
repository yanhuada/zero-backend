package com.yanhuada.common.config;

import com.yanhuada.common.exception.BaseException;
import com.yanhuada.common.exception.BaseExceptionEnum;
import com.yanhuada.common.model.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 统一管理错误
 *
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
@Controller
@RequestMapping(value = "error")
@EnableConfigurationProperties({ServerProperties.class})
public class ServerErrorController implements ErrorController {

    private ErrorAttributes errorAttributes;

    @Autowired
    private ServerProperties serverProperties;

    /**
     * 初始化ExceptionController
     * @param errorAttributes
     */
    @Autowired
    public ServerErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }


    /**
     * 定义404的ModelAndView
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(produces = "text/html",value = "404")
    public ModelAndView errorHtml404(HttpServletRequest request,
                                     HttpServletResponse response) {
        response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML));
        return new ModelAndView("error/404", model);
    }

    /**
     * 定义404的JSON数据
     * @param request
     * @return
     */
    @RequestMapping(value = "404")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error404(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML));
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }

    /**
     * 定义500的ModelAndView
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(produces = "text/html",value = "500")
    public ModelAndView errorHtml500(HttpServletRequest request,
                                     HttpServletResponse response) {
        response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML));
        return new ModelAndView("error/500", model);
    }


//    /**
//     * 定义500的错误JSON信息
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "500")
//    @ResponseBody
//    public ResponseEntity<Map<String, Object>> error500(HttpServletRequest request) {
//        Map<String, Object> body = getErrorAttributes(request,
//                isIncludeStackTrace(request, MediaType.TEXT_HTML));
//        HttpStatus status = getStatus(request);
//        return new ResponseEntity<Map<String, Object>>(body, status);
//    }

    /**
     * 定义异常JSON信息
     * @param request
     * @return
     */
    @RequestMapping
    @ResponseBody
    public ResponseDto error(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        int status = response.getStatus();
        ResponseDto responseDto = new ResponseDto();

        if (status == HttpServletResponse.SC_NOT_FOUND) {
            responseDto.setMessage("url not found");
            responseDto.setErrCode(404);
            return responseDto;
        }

        response.setStatus(HttpServletResponse.SC_OK);

        Object exception = request.getAttribute("javax.servlet.error.exception");
        if (exception == null) {
            exception = request.getAttribute("org.springframework.web.servlet.DispatcherServlet.EXCEPTION");
        }

        if (exception instanceof HttpRequestMethodNotSupportedException) {
            responseDto.setMessage("错误的http方法");
            responseDto.setErrCode(401);
            return responseDto;
        }

        if (exception instanceof BaseException) {
            responseDto.setErrCode(((BaseException) exception).getCode());
            responseDto.setMessage(((BaseException) exception).getMessage());
            return responseDto;
        }


        if (exception instanceof NestedServletException) {
            Throwable cause = ((NestedServletException) exception).getCause();

            if (cause instanceof BaseException) {
                responseDto.setErrCode(((BaseException) cause).getCode());
                responseDto.setMessage(((BaseException) cause).getMessage());
                return responseDto;
            }
        }

        responseDto.setErrCode(BaseExceptionEnum.SYSTEM_BUSY.getCode());
        responseDto.setMessage(String.format("%s:%s", body.get("status"), body.get("error")));
        return responseDto;
    }

    /**
     * Determine if the stacktrace attribute should be included.
     * @param request the source request
     * @param produces the media type produced (or {@code MediaType.ALL})
     * @return if the stacktrace attribute should be included
     */
    protected boolean isIncludeStackTrace(HttpServletRequest request,
                                          MediaType produces) {
        ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }


    /**
     * 获取错误的信息
     * @param request
     * @param includeStackTrace
     * @return
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes((WebRequest) requestAttributes,
                includeStackTrace);
    }

    /**
     * 是否包含trace
     * @param request
     * @return
     */
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    /**
     * 获取错误编码
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
