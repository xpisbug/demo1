package com.example.smdemo1;

/**
 * @author xp-dc
 * @date 2019/1/7
 */

@Table("lc_user")
public class TestTable {

	@Column("id")
	private int id;

	@Column("name")
	private String name;

	@Column("age")
	private Integer age;

	@Column("note")
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
