package UMC.study.apiPayload.exception.handler;

import UMC.study.apiPayload.code.BaseErrorCode;
import UMC.study.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
