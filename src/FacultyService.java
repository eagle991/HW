public List<Faculty> findFacultiesByNameOrColor(String query) {
    return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(query, query);
}
public List<Student> getStudentsByFacultyId(Long id) {
    return facultyRepository.findById(id)
            .map(Faculty::getStudents)
            .orElseThrow(() -> new RuntimeException("Faculty not found"));
}