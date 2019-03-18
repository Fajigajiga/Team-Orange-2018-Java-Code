package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="First Op", group="Iterative Opmode")
public class TeleopMode extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor liftMotor;
    private DcMotor elbowMotor;

    private Servo wristServo;
    private Servo clampServo;

    public void init() {
        telemetry.addData("Status", "Initialized");

        wristServo = hardwareMap.servo.get("wristServo");
        clampServo = hardwareMap.servo.get("clampServo");

        elbowMotor = hardwareMap.dcMotor.get("elbowMotor");
        liftMotor = hardwareMap.dcMotor.get("liftMotor");

        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        telemetry.addData("Status", "Initialized");
    }

    public void init_loop() {
    }

    public void start() {
        runtime.reset();
    }

    public void loop() {

        double leftPower;
        double rightPower;

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.left_stick_x;
        leftPower = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower = Range.clip(drive - turn, -1.0, 1.0) ;

        elbowMotor.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        liftMotor.setPower(gamepad2.right_stick_y);
        elbowMotor.setPower(gamepad2.left_stick_y);

        if (gamepad2.a) {

            //0 degrees.
            clampServo.setPosition(0);

        } else if (gamepad2.b) {

            //45 degrees
            clampServo.setPosition(0.25); }

        if (gamepad2.x) {

            //0 degrees.
            wristServo.setPosition(0);

        } else if (gamepad2.y) {

            //85 degrees
            wristServo.setPosition(0.55); }

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)");
    }

    public void stop () {
    }
}