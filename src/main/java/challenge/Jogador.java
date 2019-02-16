package challenge;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Jogador {

	@CsvBindByName(column = "full_name")
	private String fullName;

	@CsvBindByName(column = "nationality")
	private String nationality;

	@CsvBindByName(column = "club")
	private String club;

	@CsvBindByName(column = "release_clause")
	private Double releaseClause;

	@CsvBindByName(column = "eur_release_clause")
	private Double eurReleaseClause;

	@CsvBindByName(column = "birth_date")
	@CsvDate(value = "yyyy-MM-dd")
	private Date birthDate;

	@CsvBindByName(column = "eur_wage")
	private Double eurWage;

	@CsvBindByName(column = "age")
	private int age;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Double getReleaseClause() {
		return releaseClause;
	}

	public void setReleaseClause(Double releaseClause) {
		this.releaseClause = releaseClause;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getEurWage() {
		return eurWage;
	}

	public void setEurWage(Double eurWage) {
		this.eurWage = eurWage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getEurReleaseClause() {
		return eurReleaseClause;
	}

	public void setEurReleaseClause(Double eurReleaseClause) {
		this.eurReleaseClause = eurReleaseClause;
	}

}
