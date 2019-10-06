package com.tericcabrel.passify.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "note_groups")
public class NoteGroup extends Model {
    @Column(unique = true, nullable = false, length = 100)
    @NotBlank(message = "Name is required")
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "noteGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note> notes;

    public NoteGroup() {
        notes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public NoteGroup setName(String name) {
        this.name = name;
        return this;
    }

    public User getUser() {
        return user;
    }

    public NoteGroup setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public NoteGroup setNotes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }
}
