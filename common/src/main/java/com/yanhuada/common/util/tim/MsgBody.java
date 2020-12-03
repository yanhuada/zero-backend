package com.yanhuada.common.util.tim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class MsgBody {
    private String MsgType;
    private MsgContent MsgContent;
}
