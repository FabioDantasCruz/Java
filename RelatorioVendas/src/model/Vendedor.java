package model;

public class Vendedor {
	private String cpf;
	private String name;
	private double salary;

	public Vendedor(String cpf, String name, double salary) {

		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	
	public Vendedor(){
		this("","", 0);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
