package ypjs.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long noticeId;

    @Column(name = "notice_title")
    private String title;

    @Column(name = "notice_content")
    private String content;

    @Column(name = "notice_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "notice_cnt")
    private int cnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_member_id")
    private Member member;


    public void cntUp(Notice notice) {
        notice.cnt++;
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 생성 메소드
    public static Notice create(Member member, String title, String content) {
        Notice notice = new Notice();
        notice.member = member;
        notice.title = title;
        notice.content = content;
        notice.date = LocalDate.now();
        return notice;
    }


}
