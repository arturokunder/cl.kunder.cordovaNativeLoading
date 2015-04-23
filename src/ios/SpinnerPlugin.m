//
//  SpinnerPlugin.m
//  IMG Cinema
//
//  Created by Andrea Maschio on 24/12/13.
//
//  Updated by Modern Alchemists OG on 23/04/2014.
//

#import "SpinnerPlugin.h"
#import <Cordova/CDV.h>
#define PARAM_SHOW_OVERLAY @"overlay"
#define PARAM_AUTO_HIDE_TIMEOUT @"timeout"

@implementation SpinnerPlugin

- (void)pluginInitialize{
    //params init
    showOverlay = YES;
    connectionTimeout = 0;
}

-(void)show:(CDVInvokedUrlCommand*)options
{
    NSMutableDictionary* params = [options.arguments objectAtIndex:0];
    UIView *view = [[UIView alloc]initWithFrame:CGRectMake(0,0,self.viewController.view.frame.size.width,self.viewController.view.frame.size.height)];
    view.backgroundColor = [UIColor colorWithWhite:0.0f alpha:0.85f];
    
    
    UILabel *label = [[UILabel alloc]initWithFrame:CGRectMake(0,self.viewController.view.frame.size.height/2 -30, self.viewController.view.frame.size.width, 100)];
    label.text=@"Procesando";
    label.textColor = [UIColor whiteColor];
    label.textAlignment = NSTextAlignmentCenter;

    [view addSubview:label];
    [self.viewController.view addSubview:view];
    
    // Parse parameters
    if([params objectForKey:PARAM_AUTO_HIDE_TIMEOUT])
    {
        id connectiontimeout =[params objectForKey:PARAM_AUTO_HIDE_TIMEOUT];
        
        if([connectiontimeout isKindOfClass:[NSString class]])
        {
            NSScanner* scan = [NSScanner scannerWithString:(NSString*)connectiontimeout];
            [scan scanInt:&connectionTimeout];
        }
        else if( [connectiontimeout isKindOfClass:[NSNumber class]] )
        {
            connectionTimeout = [connectiontimeout intValue];
        }
    }
    
    id overlayParam = [params objectForKey:PARAM_SHOW_OVERLAY];
    if ([overlayParam isKindOfClass:[NSString class]])
    {
        if( [overlayParam isEqualToString:@"false"] )
        {
            showOverlay = NO;
        }
    }
    else if (![overlayParam boolValue])
    {
        showOverlay = YES; // showOverlay defaults to YES if undefined
    }
        
    if(!indicator)
    {
        indicator = [[UIActivityIndicatorView alloc]initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleWhiteLarge];
        
        // center indicator and resize/colorize frame (take screen orientation into account)
        CGRect frame = indicator.frame;
        UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
        frame.origin.x = 0;
        frame.origin.y = 0;
        if( orientation == UIInterfaceOrientationLandscapeLeft || orientation == UIInterfaceOrientationLandscapeRight )
        {
            // landscape
            frame.size.width = self.viewController.view.frame.size.height;
            frame.size.height = self.viewController.view.frame.size.width;
        }
        else
        {
            // portrait
            frame.size.width = self.viewController.view.frame.size.width;
            frame.size.height = self.viewController.view.frame.size.height - 30;
        }
        indicator.frame = frame;
        indicator.layer.cornerRadius = 0;
        indicator.opaque = YES;
        indicator.backgroundColor = [UIColor colorWithWhite:0.0f alpha:0.0f];
    }
    else
    {
        [indicator removeFromSuperview];
    }
    
    if( connectionTimeout > 0 )
    {
        NSTimer *timer __attribute__((unused))= [NSTimer scheduledTimerWithTimeInterval:connectionTimeout target:self selector:@selector(hideAfterTimeout:) userInfo:Nil repeats:NO];
    }
    
    [view addSubview:indicator];
    [indicator startAnimating];
}


-(void)hideAfterTimeout:(NSTimer*)timer
{
    [timer invalidate];
    [self hide:nil];
}

-(void)hide:(CDVInvokedUrlCommand*)options
{
    [indicator stopAnimating];
    [indicator removeFromSuperview];
    indicator = nil;
}

-(void)dispose
{
    [super dispose];
    indicator=nil;
}

@end
