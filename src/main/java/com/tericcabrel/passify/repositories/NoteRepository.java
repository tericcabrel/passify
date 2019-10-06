package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
