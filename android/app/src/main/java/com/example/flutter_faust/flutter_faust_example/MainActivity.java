package com.example.flutter_faust.flutter_faust_example;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import com.DspFaust.DspFaust;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.flutter_faust/dsp_channel";

    DspFaust dspProvider = new DspFaust(44100, 256); // TODO: get rid of hardcoded SR and Buff Size

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
            .setMethodCallHandler(
                (call, result) -> {
                    switch (call.method) {
                            case "start":
                                boolean success = dspProvider.start();
                                result.success(success);
                                break;
                            case "stop":
                                dspProvider.stop();
                                result.success(null);
                                break;
                            case "isRunning":
                                boolean isRunningResult = dspProvider.isRunning();
                                result.success(isRunningResult);
                                break;
                            case "getParamsCount":
                                int paramsCount = dspProvider.getParamsCount();
                                result.success(paramsCount);
                                break;
                            case "getParamInit": {
                                int idArg = call.argument("id");
                                float paramInit = dspProvider.getParamInit(idArg);
                                result.success((double) paramInit);
                                break;
                            }
                            case "getParamInitByPath": {
                                String pathArg = call.argument("path");
                                float paramInit = dspProvider.getParamInit(pathArg);
                                result.success((double) paramInit);
                                break;
                            }
                            case "getParamValue": {
                                int idArg = call.argument("id");
                                float paramValue = dspProvider.getParamValue(idArg);
                                result.success((double) paramValue);
                                break;
                            }
                            case "getParamValueByPath": {
                                String pathArg = call.argument("path");
                                float paramValue = dspProvider.getParamValue(pathArg);
                                result.success((double) paramValue);
                                break;
                            }
                            case "getParamMin": {
                                int idArg = call.argument("id");
                                float paramMin = dspProvider.getParamMin(idArg);
                                result.success((double) paramMin);
                                break;
                            }
                            case "getParamMinByPath": {
                                String pathArg = call.argument("path");
                                float paramMin = dspProvider.getParamMin(pathArg);
                                result.success((double) paramMin);
                                break;
                            }
                            case "getParamMax": {
                                int idArg = call.argument("id");
                                float paramMax = dspProvider.getParamMax(idArg);
                                result.success((double) paramMax);
                                break;
                            }
                            case "getParamMaxByPath": {
                                String pathArg = call.argument("path");
                                float paramMax = dspProvider.getParamMax(pathArg);
                                result.success((double) paramMax);
                                break;
                            }
                            case "setParamValue": {
                                int idArg = call.argument("id");
                                double valueArg = call.argument("value");
                                dspProvider.setParamValue(idArg, (float) valueArg);
                                result.success(null);
                                break;
                            }
                            case "setParamValueByPath": {
                                String pathArg = call.argument("path");
                                double valueArg = call.argument("value");
                                dspProvider.setParamValue(pathArg, (float) valueArg);
                                result.success(null);
                                break;
                            }
                            case "keyOn": {
                                int pitchArg = call.argument("pitch");
                                int velocityArg = call.argument("velocity");
                                long voiceId = dspProvider.keyOn(pitchArg, velocityArg);
                                result.success((int) voiceId);
                                break;
                            }
                            case "keyOff": {
                                int pitchArg = call.argument("pitch");
                                int keyOffResult = dspProvider.keyOff(pitchArg);
                                result.success(keyOffResult);
                                break;
                            }
                            case "allNotesOff":
                                dspProvider.allNotesOff();
                                result.success(null);
                                break;
                            case "newVoice": {
                                long voiceId = dspProvider.newVoice();
                                result.success((int) voiceId);
                                break;
                            }
                            case "deleteVoice": {
                                long voiceArg = call.argument("voice");
                                int deleteVoiceResult = dspProvider.deleteVoice(voiceArg);
                                result.success(deleteVoiceResult);
                                break;
                            }
                            case "setVoiceParamValueByPath": {
                                String pathArg = call.argument("path");
                                long voiceArg = call.argument("voice");
                                double valueArg = call.argument("value");
                                dspProvider.setVoiceParamValue(pathArg, voiceArg, (float) valueArg);
                                result.success(null);
                                break;
                            }
                            case "getVoiceParamValueByPath": {
                                String pathArg = call.argument("path");
                                long voiceArg = call.argument("voice");
                                float voiceParamValue = dspProvider.getVoiceParamValue(pathArg, voiceArg);
                                result.success((double) voiceParamValue);
                                break;
                            }
                            case "getCPULoad":
                                float cpuLoad = dspProvider.getCPULoad();
                                result.success((double) cpuLoad);
                                break;
                            case "getJSONUI":
                                String jsonUi = dspProvider.getJSONUI();
                                result.success(jsonUi);
                                break;
                            case "getJSONMeta":
                                String jsonMeta = dspProvider.getJSONMeta();
                                result.success(jsonMeta);
                                break;
                            default:
                                result.notImplemented();
                                break;
                        }
                }
            );
        super.configureFlutterEngine(flutterEngine);
    }
}