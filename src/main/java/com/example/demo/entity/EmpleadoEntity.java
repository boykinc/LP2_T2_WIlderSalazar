package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tb_empleado")
public class EmpleadoEntity {

	@Id
	@Column(name = "dni_empleado",
			nullable = false ,
			length = 8 ,
			columnDefinition = "CHAR(8)" )
	private String dniEmple;
	
	@Column(name = "nombre_empleado",
			nullable = false ,
			length = 45 ,
			columnDefinition = "VARCHAR(45)" )
	private String nomEmple;
	
	@Column(name = "apellido_empleado",
			nullable = false ,
			length = 45 ,
			columnDefinition = "VARCHAR(45)" )
	private String apeEmple;
	
	@Column(name = "fecha_nacimiento" ,
			nullable = false ,
			updatable = true
			)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fenacEmple;
	
	@Column(name = "direccion" ,
			nullable = false ,
			length = 45,
			columnDefinition = "VARCHAR(45)"
			)
	private String dirEmple; 
	
	@Column(name = "correo" ,
			nullable = false ,
			length = 45,
			columnDefinition = "VARCHAR(45)"
			)
	private String correoEmple; 
	
	@ManyToOne
	@JoinColumn(name="areaId")
	private AreaEntity areas;
}
