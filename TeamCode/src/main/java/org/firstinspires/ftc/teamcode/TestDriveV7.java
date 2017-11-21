package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TestDriveV7")
public class TestDriveV7 extends OpMode {

    final static double MOTOR_POWER = 0.15;

    DcMotor motorRight;
    DcMotor motorLeft;
    DcMotor motorJack;
    DcMotor motorJewel;
    DcMotor motorArm;
    Servo servoClawLeft;
    Servo servoClawRight;
    DcMotor motorRelic;

    public TestDriveV7(){

    }

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get("rightMotor");
        motorLeft = hardwareMap.dcMotor.get("leftMotor");
        motorJack = hardwareMap.dcMotor.get("jackMotor");
        motorArm = hardwareMap.dcMotor.get("armMotor");
        motorJewel = hardwareMap.dcMotor.get("jewelMotor");
        servoClawLeft = hardwareMap.servo.get("leftclawServo");
        servoClawRight = hardwareMap.servo.get("rightclawServo");
        motorRelic = hardwareMap.dcMotor.get("relicMotor");


        motorLeft.setDirection(DcMotor.Direction.FORWARD);
        motorRight.setDirection(DcMotor.Direction.REVERSE);
        motorJack.setDirection(DcMotor.Direction.REVERSE);
        motorJewel.setDirection(DcMotor.Direction.REVERSE);
        servoClawLeft.setDirection(Servo.Direction.FORWARD);
        servoClawRight.setDirection(Servo.Direction.REVERSE);
        motorRelic.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {

        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float DPUP = gamepad1.dpad_up  ? 1.0f : 0.0f;
        float DPWN = gamepad1.dpad_down  ? 1.0f : 0.0f;
        float UY = gamepad2.y  ? 1.0f : 0.0f;
        float DA = gamepad2.a  ? 1.0f : 0.0f;
        float SCI = gamepad2.left_trigger;
        float SCO = gamepad2.right_trigger;
        float lefty = gamepad2.left_stick_y;
        float righty = gamepad2.right_stick_y;
        float DPOT = gamepad2.dpad_up  ? 1.0f : 0.0f;
        float DPIN = gamepad2.dpad_down  ? 1.0f : 0.0f;

        motorLeft.setPower(leftY);
        motorRight.setPower(rightY);
        motorArm.setPower(lefty);
        motorJewel.setPower(righty);

        if (gamepad2.dpad_up) {
            motorRelic.setPower(DPOT);
        }
        else if (gamepad2.dpad_down) {
            motorRelic.setPower(-DPIN);
        }
        else {
            motorRelic.setPower(0.0);
        }


        if (gamepad2.left_trigger>0) {
            servoClawLeft.setPosition(SCI);
            servoClawRight.setPosition(SCI);
        }

        else if (gamepad2.right_trigger>0) {
            servoClawLeft.setPosition(-SCO);
            servoClawRight.setPosition(-SCO);
        }
        else {
            servoClawLeft.setPosition(0.0);
            servoClawRight.setPosition(0.0);
        }

        if (gamepad1.dpad_up) {
            motorJack.setPower(-DPUP);
        }
        else if (gamepad1.dpad_down) {
            motorJack.setPower(DPWN);
        }
        else {
            motorJack.setPower(0.0);
        }

        if (gamepad2.y) {
            motorArm.setPower(UY);
        }
        else if (gamepad2.a) {
            motorArm.setPower(DA);
        }
        else {
            motorArm.setPower(0.0);
        }


    }
}