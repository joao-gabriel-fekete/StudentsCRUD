package get.academic.api.controller;

import get.academic.api.record.StudentsDataList;
import get.academic.api.record.UpdateStudentsData;
import get.academic.api.student.Student;
import get.academic.api.student.StudentRepository;
import get.academic.api.record.StudentsData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    @Transactional
    public void register (@RequestBody @Valid StudentsData studentsData){
        repository.save(new Student(studentsData));
    }

    @GetMapping
    public Page<StudentsDataList> getStudents(@PageableDefault(size = 10) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(StudentsDataList::new);
    }

    @PutMapping
    @Transactional
    public void updateStudents(@RequestBody @Valid UpdateStudentsData studentsDataForUpdate){
        var student = repository.getReferenceById(studentsDataForUpdate.id());
        student.updateData(studentsDataForUpdate);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excludeStudent(@PathVariable Long id){
        var student = repository.getReferenceById(id);
        student.changeStatus();
    }

}
