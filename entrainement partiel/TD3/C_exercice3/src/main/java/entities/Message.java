package entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id @GeneratedValue
    private int msgId;
    @Basic
    private LocalDateTime msgDate;
    private String text;
    @ManyToOne
    private MyUser from;
    @ManyToOne
    private MyUser to;

    public Message() {
    }

    public Message(String text, MyUser from, MyUser to) {
        this.text = text;
        this.from = from;
        this.to = to;
        this.msgDate=LocalDateTime.now();
    }

    public int getMsgId() {
        return msgId;
    }

    public LocalDateTime getMsgDate() {
        return msgDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MyUser getFrom() {
        return from;
    }

    public void setFrom(MyUser from) {
        this.from = from;
    }

    public MyUser getTo() {
        return to;
    }

    public void setTo(MyUser to) {
        this.to = to;
    }
}
