package com.asaf.StackOverflowClone.Services;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
}
