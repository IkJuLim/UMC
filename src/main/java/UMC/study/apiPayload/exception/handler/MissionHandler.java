package UMC.study.apiPayload.exception.handler;

import UMC.study.apiPayload.code.BaseErrorCode;
import UMC.study.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
