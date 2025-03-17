@GetMapping("/faculties/search")
public List<Faculty> findFacultiesByNameOrColor(@RequestParam String query) {
    return facultyService.findFacultiesByNameOrColor(query);
}
@GetMapping("/faculties/{id}/students")
public List<Student> getStudentsByFacultyId(@PathVariable Long id) {
    return facultyService.getStudentsByFacultyId(id);
}