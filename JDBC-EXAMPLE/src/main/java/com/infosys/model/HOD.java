package com.infosys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HOD {
	private Integer hod_id;
	private String hod_name;
	private Integer hod_experience;
	private Integer hod_incharge_date;
	private Integer dept_id;
	
}
