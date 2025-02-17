package App.LMS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    private String id;

    private String userId;
    private String message;
    private String type; // INFO, WARNING, SUCCESS

    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean read = false;
}
