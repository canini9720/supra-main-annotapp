package com.supra.annot.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supra.annot.common.util.CommonConstants;
import com.supra.annot.service.SupraService;
import com.supra.supra.service.ShiporderRequest;



@Service("supraService")
@Transactional
public class SupraServiceImpl implements SupraService {
	
	private static final Logger loggerInfo = Logger.getLogger(CommonConstants.LOGGER_SUPRA_SERVICES_INFO);
	
	//@Autowired
	//private ApplicantInfoRepository appInfoRepository;

	/*@Override
	public int saveApplicantInfo(SaveApplicantInfoRequest appInfo) throws Exception {
		loggerInfo.info(appInfo);
		ApplicantInfoServiceImplUtil.validatesaveApplicantInfo(appInfo);
		
		ApplicantInfoEntity appInfoEntity=new ApplicantInfoEntity();
		ApplicantAddressEntity addressEntity=new ApplicantAddressEntity();
		ApplicantDigInfoEntity diagnosisEntity=new ApplicantDigInfoEntity();
		ApplicantDisdCardInfoEntity disdCardInfoEntity=new ApplicantDisdCardInfoEntity();
		
		BeanUtils.copyProperties(appInfo, appInfoEntity);
		BeanUtils.copyProperties(appInfo.getAddressDTO(), addressEntity);
		BeanUtils.copyProperties(appInfo.getDiganosisInfoDTO(), diagnosisEntity);
		BeanUtils.copyProperties(appInfo.getDisabledCardInfoDTO(), disdCardInfoEntity);

		Date dobDate=CommonUtil.getDatefromString(appInfo.getDateOfBirth(), CommonConstants.DATE_ddMMyyyy);
		Date resiExpDate=CommonUtil.getDatefromString(appInfo.getResidenceExpiryDate(), CommonConstants.DATE_ddMMyyyy);
		Date diagReportDate=CommonUtil.getDatefromString(appInfo.getDiganosisInfoDTO().getReportDate(), CommonConstants.DATE_ddMMyyyy);
		Date cardIssueDate=CommonUtil.getDatefromString(appInfo.getDisabledCardInfoDTO().getCardIssueDate(), CommonConstants.DATE_ddMMyyyy);
		Date cardExpiryDate=CommonUtil.getDatefromString(appInfo.getDisabledCardInfoDTO().getCardExpiryDate(), CommonConstants.DATE_ddMMyyyy);
		
		appInfoEntity.setDateOfBirth(dobDate);
		appInfoEntity.setResidenceExpiryDate(resiExpDate);
		diagnosisEntity.setReportDate(diagReportDate);
		disdCardInfoEntity.setCardIssueDate(cardIssueDate);
		disdCardInfoEntity.setCardExpiryDate(cardExpiryDate);

		appInfoEntity.setAddressEntity(addressEntity);
		appInfoEntity.setDiagnosisEntity(diagnosisEntity);
		appInfoEntity.setDisdCardInfoEntity(disdCardInfoEntity);
		
		addressEntity.setApptInfo(appInfoEntity);
		diagnosisEntity.setApptInfo(appInfoEntity);
		disdCardInfoEntity.setApptInfo(appInfoEntity);
		
		if(appInfoRepository.save(appInfoEntity) != null){
			return CommonConstants.INT_ONE_YES;
		}else {
			return CommonConstants.INT_ZERO_NO;
		}
	}*/

	@Override
	public int saveShiporder(ShiporderRequest request) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
