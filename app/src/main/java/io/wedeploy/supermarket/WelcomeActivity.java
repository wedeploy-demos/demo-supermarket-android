package io.wedeploy.supermarket;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import io.wedeploy.supermarket.databinding.ActivityWelcomeBinding;
import io.wedeploy.supermarket.login.LoginActivity;

/**
 * @author Silvio Santos
 */
public class WelcomeActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Settings.getInstance(this).isLoggedIn()) {
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}

		ActivityWelcomeBinding binding = DataBindingUtil.setContentView(
			this, R.layout.activity_welcome);

		binding.signInButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
			}
		});

		binding.signUpButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
			}
		});

	}
}
