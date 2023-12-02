package UMC.study.apiPayload.exception.handler;

import UMC.study.apiPayload.code.BaseErrorCode;
import UMC.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
