import 'package:flutter/material.dart';
import 'dsp_api.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Faust Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key = const Key('HomePage')}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  bool _gate = false;
  double _gain = 1;

  @override
  void initState() {
    DspApi.start();
    super.initState();
  }

  void _toggleBeep() {
    setState(() {
      _gate = !_gate;
    });

    DspApi.setParamValueByPath("gate", _gate ? 1 : 0);
  }

  void _setGain(double gain) {
    setState(() {
      _gain = gain;
    });
    DspApi.setParamValueByPath("gain", gain);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text('Gain:'),
          Slider(
              value: _gain,
              min: 0,
              max: 1,
              onChanged: _setGain,
          ),
          ElevatedButton(
            onPressed: _toggleBeep,
            child: Text(_gate ? 'Stop' : 'Beep'),
            style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all<Color>(
                    _gate ? Colors.red : Colors.amber)),
          ),
        ],
      ),
    );
  }
}