package com.asaf.StackOverflowClone.Controller;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> postQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.findAllQuestions(), HttpStatus.OK);
    }
    @PutMapping("/questions/{id}/upvote")
public ResponseEntity<Question> upvoteQuestion(@PathVariable String id) {
    Optional<Question> optionalQuestion = questionRepository.findById(id);
    if (optionalQuestion.isPresent()) {
        Question question = optionalQuestion.get();
        question.setUpvotes(question.getUpvotes() + 1);
        questionRepository.save(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@PutMapping("/questions/{id}/downvote")
public ResponseEntity<Question> downvoteQuestion(@PathVariable String id) {
    Optional<Question> optionalQuestion = questionRepository.findById(id);
    if (optionalQuestion.isPresent()) {
        Question question = optionalQuestion.get();
        question.setDownvotes(question.getDownvotes() + 1);
        questionRepository.save(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@GetMapping("/questions/search")
public ResponseEntity<List<Question>> searchQuestions(@RequestParam String keyword) {
    List<Question> questions = questionRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
    return new ResponseEntity<>(questions, HttpStatus.OK);
}
}
