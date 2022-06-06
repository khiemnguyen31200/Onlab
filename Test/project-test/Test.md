## 1. @Entity(name = ‘EntityName’) dùng để chỉ tên của entity được Hibernate quản lý trong khi @Table(name = “TableName”) chỉ đích danh tên của table dưới database. 

## 2. Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties câu lệnh như sau:

```sql 
spring.jpa.properties.hibernate.format_sql=true
```

## 3.Ta truy cập vào h2-console

## 4. Annotation @Transient

## 5. 
### Annotation @Column bổ sung thêm các tính chất ràng buộc cho trường dữ liệu (ví dụ kiểu dữ liệu, số kí tự , có được rỗng hay không,v.v)
### Để đổi tên cho cột ta dùng tham số `name` trong @Column
### Để yêu cầu tính duy nhất ta dùng tham số `unique` trong @Column
### Để buộc trường không được null ta dùng tham số `nullable` trong @Column

## 6. 

### Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT) dùng annotation @PrePersist

### Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE) dùng annotation @PreUpdate

## 7. @Embedded và @Embeddable

## 8. JPA Repository kế thừa các interface :CRUD Repository , Paging And Sorting Repository

## 9. 
```java
    @Repository
    public interface PostRepo extends JpaRepository<Post, Long> {}
```

## 10.Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì không phải dùng xác định unique dùng annotation @Column(unique=true) vì bản thân @Id đã chứa thuộc tính Not null và unique 

## 11. Khác biệt giữa @Id với @NaturalId là gì?

`@Id` không cho phép thay đổi vì nó là khóa chính liên kết các bảng khác
`@NaturalId` không phải là khóa chính, cho phép thay đổi dữ liệu miễn sao không trùng lặp với dữ liệu khác

## 12. Đánh chỉ mục (index) để tìm kiếm nhanh hơn ta dùng @Index
```java
@Entity
@Table(indexes = {
  @Index(columnList = "firstName"),@Index(name = "fn_index", columnList = "firstName")})
public class Job {
    @Id @GeneratedValue private UUID id;
    private String title;
    private String description;

}
```

## 13. 
### Nếu trường là kiểu String thì ta vẫn có thể sử dụng @GeneratedValue để tạo ra id độc nhất
### Có hai cái tạo ra chuỗi id độc nhất đó là tự customID hoặc sử dụng UUID

## 14. Trong project

## 15. 

###  @NamedQuery: Query sử dụng ở nhiều nơi khác nhau .
###  @Query:  Ta có thể khai báo câu query cho các method trong repository để thực hiện việc truy vấn các cơ sở dữ liệu


## 16. Custom method trong JPA  Repository : Ta tạo ra một Service để tạo custom method. Service được inject các thuộc tính các hàm có được từ JPA Repository để tiếp xúc với dữ liệu. Ví dụ đã làm trên câu 14

## 18. Đã xong trong project




