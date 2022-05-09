package vn.techmaster.job_hunt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
  private String id;
  private String emp_id;
  private String title;
  private String description;
  private City city;
  private LocalDateTime updateTime;
  private LocalDateTime createTime;

  public boolean SearchByKeyword(String search, String citySearch) {
    return (title.toLowerCase().contains(search.toLowerCase())
            &&citySearch.contains(city.label));
  }
  public boolean SearchByCity(String citySearch) {
    return citySearch.contains(city.label);
  }
  public boolean SearchByOnlyKeyword(String search) {
    return (title.toLowerCase().contains(search.toLowerCase()));
  }
}
