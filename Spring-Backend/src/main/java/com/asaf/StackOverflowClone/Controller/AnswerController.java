package com.asaf.StackOverflowClone.Controller;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<Answer> postAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<>(answerService.saveAnswer(answer), HttpStatus.CREATED);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersForQuestion(@PathVariable String questionId) {
        return new ResponseEntity<>(answerService.findAnswersByQuestionId(questionId), HttpStatus.OK);
    }
}
