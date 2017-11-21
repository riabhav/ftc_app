package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "LandonOpMode")
public class LandonOpMode extends OpMode {
    final static double MOTOR_POWER = 0.15;

    DcMotor motorLeft;
    DcMotor motorRight;
    //Servo arm;

    public LandonOpMode(){

    }

    @Override
    public void init() {
        motorRight = hardwareMap.dcMotor.get(KeysI.RIGHT_MOTOR);
        motorLeft = hardwareMap.dcMotor.get(KeysI.LEFT_MOTOR);
        //arm = hardwareMap.servo.get("centerArm");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {
        /*float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float leftX = gamepad1.left_stick_x;



        motorLeft.setPower(leftY);
        motorRight.setPower(leftY);*/

        DeviceUtils.startDriving(motorLeft, motorRight, gamepad1);
        //DeviceUtils.startArmMotor(DcMotor armMotor, Gamepad gamepad1);
    }


    public void goForward(){

    }



}