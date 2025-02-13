package ypjs.project.dto.itemdto;

import lombok.Getter;
import ypjs.project.domain.ItemReview;

import java.time.LocalDateTime;

@Getter
public class ItemReviewListDto {

    Long itemReviewId;
    Long itemId;
    String nickname;
    Long memberId;
    private int score;
    private String title;
    private String content;
    private LocalDateTime createDate;



    public ItemReviewListDto() {}

    public ItemReviewListDto(ItemReview itemReview) {

        itemReviewId = itemReview.getItemReviewId();
        itemId = itemReview.getItem().getItemId();
        nickname = itemReview.getMember().getNickname();
        memberId = itemReview.getMember().getMemberId();
        score = itemReview.getScore();
        title = itemReview.getTitle();
        content = itemReview.getContent();
        createDate = itemReview.getCreateDate();


    }



}
