package com.it.judgemindbackendjudgeservice.judge;

import com.it.judgemindbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.it.judgemindbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.it.judgemindbackendjudgeservice.judge.strategy.JudgeContext;
import com.it.judgemindbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.it.judgemindbackendmodel.model.codesandbox.JudgeInfo;
import com.it.judgemindbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
