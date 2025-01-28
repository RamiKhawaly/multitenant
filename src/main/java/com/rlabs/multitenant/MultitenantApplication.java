package com.rlabs.multitenant;

import com.rlabs.multitenant.beans.Activity;
import com.rlabs.multitenant.beans.Tenant;
import com.rlabs.multitenant.beans.User;
import com.rlabs.multitenant.multiTenant.TenantContext;
import com.rlabs.multitenant.repo.ActivityRepo;
import com.rlabs.multitenant.repo.TenantRepo;
import com.rlabs.multitenant.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MultitenantApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantApplication.class, args);
	}

	@Autowired
	private TenantRepo tenantRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ActivityRepo activityRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		Long rlabsId = tenantRepo.save(Tenant.builder().name("RLabs").build()).getId();
		Long mindolifeId = tenantRepo.save(Tenant.builder().name("MindoLife").build()).getId();
		TenantContext.setTenantId(rlabsId+"");
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		User user = new User();
		//user.setTenantId(rlabsId+"");
		user.setName("Rami");
		user.setEmail("ramix@mindolife.com");
		userRepo.save(user);



		Activity activity1 = new Activity();
		//activity1.setTenantId(rlabsId+"");
		activity1.setTitle("Test Rlabs");

		activityRepo.save(activity1);

		TenantContext.setTenantId(mindolifeId+"");
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		Activity activity2 = new Activity();
		//activity2.setTenantId(mindolifeId+"");
		activity2.setTitle("Test MindoLife");

		activityRepo.save(activity2);

		TenantContext.clear();
	}
}
