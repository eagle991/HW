public List<Student> getStudentsByAgeBetween(int min, int max) {
    return studentRepository.findByAgeBetween(min, max);
}
public Faculty getFacultyByStudentId(Long id) {
    return studentRepository.findById(id)
            .map(Student::getFaculty)
            .orElseThrow(() -> new RuntimeException("Student not found"));
}