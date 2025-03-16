@GetMapping("/students/age-between")
public List<Student> getStudentsByAgeBetween(@RequestParam int min, @RequestParam int max) {
    return studentService.getStudentsByAgeBetween(min, max);
}
@GetMapping("/students/{id}/faculty")
public Faculty getFacultyByStudentId(@PathVariable Long id) {
    return studentService.getFacultyByStudentId(id);
}