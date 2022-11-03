package com.sb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist {
	private Integer tid;
	private String tname;
	private String tcity;
	private String tstate;
	
}
