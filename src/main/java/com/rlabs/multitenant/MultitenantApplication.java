package com.rlabs.multitenant;

import com.rlabs.multitenant.beans.Activity;
import com.rlabs.multitenant.beans.security.tenant.Tenant;
import com.rlabs.multitenant.security.tenant.TenantContext;
import com.rlabs.multitenant.repo.ActivityRepo;
import com.rlabs.multitenant.repo.security.tenant.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultitenantApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantApplication.class, args);
	}

	@Autowired
	private TenantRepo tenantRepo;


	@Autowired
	private ActivityRepo activityRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		Long rlabsId = tenantRepo.save(Tenant.builder().name("RLabs").build()).getId();
		Long mindolifeId = tenantRepo.save(Tenant.builder().name("MindoLife").build()).getId();
		TenantContext.setTenantId(rlabsId+"");
		System.out.println("Current tenant:"+TenantContext.getTenantId());

		Activity activity1 = new Activity();
		activity1.setTitle("Test Rlabs");

		activityRepo.save(activity1);

		TenantContext.setTenantId(mindolifeId+"");
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		Activity activity2 = new Activity();
		activity2.setTitle("Test MindoLife");

		activityRepo.save(activity2);

		TenantContext.clear();
	}
}
