package com.tericcabrel.passify.models;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note extends Model {
    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String content;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private NoteGroup noteGroup;

    public String getTitle() {
        return title;
    }

    public Note setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Note setContent(String content) {
        this.content = content;
        return this;
    }

    public NoteGroup getNoteGroup() {
        return noteGroup;
    }

    public Note setNoteGroup(NoteGroup noteGroup) {
        this.noteGroup = noteGroup;
        return this;
    }
}
