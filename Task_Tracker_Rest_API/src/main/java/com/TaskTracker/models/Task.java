package com.TaskTracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Title is required")
	@NotNull(message = "Title is required")
	@NotBlank(message = "Title is required")
	private String title;
	
	@NotEmpty(message = "description is required")
	@NotNull(message = "description is required")
	@NotBlank(message = "description is required")
    private String description;
	
	@Enumerated(EnumType.STRING)
    private TaskStatus status;
    

}
