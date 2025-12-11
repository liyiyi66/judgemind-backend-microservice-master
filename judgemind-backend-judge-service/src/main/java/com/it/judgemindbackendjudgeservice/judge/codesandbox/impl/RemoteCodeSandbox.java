package com.it.judgemindbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.it.judgemindbackendcommon.common.ErrorCode;
import com.it.judgemindbackendcommon.exception.BusinessException;
import com.it.judgemindbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.it.judgemindbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.it.judgemindbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.it.judgemindbackendmodel.model.codesandbox.JudgeInfo;
import com.it.judgemindbackendmodel.model.enums.JudgeInfoMessageEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteCodeSandbox implements CodeSandbox {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8080/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse = JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
        JudgeInfo judgeInfo = new JudgeInfo();
        if("编译错误".equals(executeCodeResponse.getMessage())) {
            judgeInfo.setMessage(JudgeInfoMessageEnum.COMPILE_ERROR.getValue());
            executeCodeResponse.setJudgeInfo(judgeInfo);
        } else if ("执行错误".equals(executeCodeResponse.getMessage())) {
            judgeInfo.setMessage(JudgeInfoMessageEnum.RUNTIME_ERROR.getValue());
            executeCodeResponse.setJudgeInfo(judgeInfo);
        }
        return executeCodeResponse;
    }
}
