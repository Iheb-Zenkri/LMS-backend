package App.LMS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs") // Stored in MongoDB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    private String id;

    private String userId;
    private String action;
    private LocalDateTime timestamp = LocalDateTime.now();
}

