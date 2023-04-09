cmake_minimum_required(VERSION 3.4.1)

add_library(
        dsp_faust
        SHARED
        src/main/cpp/java_interface_wrap.cpp
        src/main/cpp/DspFaust.cpp
)

find_library( log-lib log )
find_package(oboe REQUIRED CONFIG)
target_link_libraries( dsp_faust ${log-lib} oboe::oboe )

include_directories(src/main/cpp/include/)