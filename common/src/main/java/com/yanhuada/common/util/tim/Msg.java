package com.yanhuada.common.util.tim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Msg {
    private Integer SyncOtherMachine;
    private String To_Account;
    private Integer MsgLifeTime;
    private Integer MsgRandom;
    private Long MsgTimeStamp;
    private List<String> ForbidCallbackControl;
    private List<MsgBody> MsgBody;
}
