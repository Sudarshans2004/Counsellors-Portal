package com.miniproject.Counsellors_Portal.dto;

import lombok.Data;

@Data
public class DashBoardResponse {

    private Integer totalEnqs;
    private Integer openEnqs;
    private Integer enrollEnqs;
    private Integer lostEnqs;


}
