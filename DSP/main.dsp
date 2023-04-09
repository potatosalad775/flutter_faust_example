import("stdfaust.lib");
gate = button("gate") : si.smoo;
gain = hslider("gain", 1, 0, 1, 0.01);
process = os.sawtooth(440) * gate * gain <: _,_;