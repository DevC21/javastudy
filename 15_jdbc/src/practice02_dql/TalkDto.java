package practice02_dql;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor /* default constructor */
@AllArgsConstructor /* constructor using field */
@Getter
@Setter
@ToString /* toString() */
public class TalkDto {
  private	int TALK_NO;
  private	String TALK_CONTENT;
  private	String TALK_USER;
  private	Timestamp WRITTEN_AT;
}
