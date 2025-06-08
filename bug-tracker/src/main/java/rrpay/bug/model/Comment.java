package rrpay.bug.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {
    private String text;
    private User author;
}
