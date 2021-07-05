package com.clockOn.web.service.vacation;

import com.clockOn.web.entity.vacation.Annday;

public interface LeaveService {
   /*직원 총연차, 남은연차 얻기*/
   Annday getVacinfo(String emp_id);
}