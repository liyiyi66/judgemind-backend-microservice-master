package com.it.judgemindbackendjudgeservice.judge.strategy;

import com.it.judgemindbackendmodel.model.codesandbox.JudgeInfo;
import com.it.judgemindbackendmodel.model.dto.question.JudgeCase;
import com.it.judgemindbackendmodel.model.entity.Question;
import com.it.judgemindbackendmodel.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
