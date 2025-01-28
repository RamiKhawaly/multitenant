package com.rlabs.multitenant;

import com.rlabs.multitenant.beans.Activity;
import com.rlabs.multitenant.beans.User;
import com.rlabs.multitenant.beans.security.tenant.Tenant;
import com.rlabs.multitenant.repo.UserRepository;
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

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		Tenant tenant1 = Tenant.builder().name("RLabs").domain("rlabs.nexus.com").build();
		Tenant tenant2 = Tenant.builder().name("MindoLife").domain("mindolife.nexus.com").build();
		Long rlabsId = tenantRepo.save(tenant1).getId();
		Long mindolifeId = tenantRepo.save(tenant2).getId();
		TenantContext.setTenantId(rlabsId+"");
		System.out.println("Current tenant:"+TenantContext.getTenantId());
		//Data willl be registered under the rlabs tenant
		User user = new User();
		user.setUsername("ramix");
		user.setPassword("rami1234");
		user.setEmail("ramix@rlabs.com");
		user.setEnabled(true);
		user.setTenant(tenant1);
		this.userRepository.save(user);


		Activity activity1 = new Activity();
		activity1.setTitle("Test Rlabs");

		activityRepo.save(activity1);

		TenantContext.setTenantId(mindolifeId+"");
		System.out.println("Current tenant:"+TenantContext.getTenantId());

		//Data willl be registered under the mindolife tenant

		Activity activity2 = new Activity();
		activity2.setTitle("Test MindoLife");

		activityRepo.save(activity2);

		User user1 = new User();
		user1.setUsername("dani");
		user1.setPassword("dani234");
		user1.setEmail("dani@mindolife.com");
		user1.setEnabled(true);
		user1.setTenant(tenant2);
		this.userRepository.save(user1);

		TenantContext.clear();
	}
}
