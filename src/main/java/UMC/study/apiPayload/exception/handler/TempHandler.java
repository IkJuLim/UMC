package UMC.study.apiPayload.exception.handler;

import UMC.study.apiPayload.code.BaseErrorCode;
import UMC.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}