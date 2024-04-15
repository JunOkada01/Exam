package jp.ac.fgrope.Money.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name = "users")
public class UserBook{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 64, nullable = false)
	private String firstname;
	
	@Column(length = 64, nullable = false)
	private String lastname;
 
	@Column(length = 128, nullable = true)
	private String email;
	
	@Column(nullable = false)
	private String balance;
	
	@Column(length = 64, nullable = false)
	private String username;
	
	@Column(length = 64, nullable = false)
	private String password;
 
}
