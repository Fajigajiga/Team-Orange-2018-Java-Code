package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Auton Close")
public class AutonomousClose extends LinearOpMode {
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor liftMotor;
    public Servo wristServo;
    public Servo clampServo;

    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        liftMotor = hardwareMap.dcMotor.get("liftMotor");
        wristServo = hardwareMap.servo.get("wristServo");
        clampServo = hardwareMap.servo.get("clampServo");

        waitForStart();

        //Lift goes up for 3 seconds to detatch from the lander

        wristServo.setPosition(0);
        clampServo.setPosition(0);

        liftMotor.setPower(-1);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(3000);

        //Zero everything

        wristServo.setPosition(0);
        clampServo.setPosition(0);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(2000);

        //1.385 second drives us for 36 inches to the totem square

        wristServo.setPosition(0);
        clampServo.setPosition(0);

        leftDrive.setPower(-1);
        rightDrive.setPower(1);

        sleep(1500);

        //The wrist drops and everything else is zero to stop the robot for 2 seconds

        wristServo.setPosition(0.55);
        clampServo.setPosition(0);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(2000);

        //Just to make sure it works perfect
        wristServo.setPosition(0.55);
        clampServo.setPosition(0);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(1000);

        //Wrist is already down and the clamp opens to drop totem for 2 seconds

        wristServo.setPosition(0.55);
        clampServo.setPosition(0.25);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(2000);

        //Zero everything to make sure its perfect
        wristServo.setPosition(0);
        clampServo.setPosition(0.25);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(1000);

        //The wrist comes up and the robot turns 135 degrees to drive towards the ball pit which takes .792 seconds

        wristServo.setPosition(0);
        clampServo.setPosition(0.25);

        leftDrive.setPower(-1);
        rightDrive.setPower(-1);

        sleep(1500);

        //Zero out everything except the clamp

        wristServo.setPosition(0);
        clampServo.setPosition(0.25);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(1000);

        //Bring the lift up
        wristServo.setPosition(0);
        clampServo.setPosition(.25);

        liftMotor.setPower(1);
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(3000);

        //Drive forward to reach the ball pit in 3.8 seconds while keeping the clamp and wrist servo's up

        wristServo.setPosition(0);
        clampServo.setPosition(0.25);

        leftDrive.setPower(-1);
        rightDrive.setPower(1);

        sleep(4000);

        //Stop robot until end of 30 seconds

        wristServo.setPosition(0);
        clampServo.setPosition(0.25);

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(8000);
    }

}