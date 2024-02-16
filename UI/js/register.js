function sendOTP() {
    const mobile = document.getElementById("mobile").value;
  
    // Validate the mobile number
    if (!isValidMobileNumber(mobile)) {
      alert("Invalid mobile number. Please enter a valid number.");
      return;
    }
  
    // Generate and send OTP logic goes here (you may use a backend API)
  
    // For simplicity, let's just log the OTP to the console
    const otp = Math.floor(1000 + Math.random() * 9000);
    console.log(`Your OTP is: ${otp}`);
  
    // Show the OTP input and submit button
    document.getElementById("otpContainer").style.display = "block";
    document.getElementById("submitBtn").style.display = "block";
  }
  
  function isValidMobileNumber(mobile) {
    // You may want to implement more robust validation logic
    return /^[0-9]{10}$/.test(mobile);
  }
  
  function submitForm() {
    const fullName = document.getElementById("fullName").value;
    const mobile = document.getElementById("mobile").value;
    const otp = document.getElementById("otp").value;
  
    // Validate OTP (you may want to compare it with the generated OTP on the server)
    if (otp.length !== 4 || isNaN(otp)) {
      alert("Invalid OTP. Please enter a 4-digit number.");
      return;
    }
  
    // Registration logic goes here (you may use a backend API)
    // For simplicity, let's just log the registration details to the console
    console.log("Registration successful!");
    console.log("Full Name:", fullName);
    console.log("Mobile:", mobile);
  }
  